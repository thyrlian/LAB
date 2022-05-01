#! /usr/bin/env ruby

require 'nokogiri'
require 'open-uri'

base_url = "https://en.wikipedia.org/wiki/List_of_airports_by_IATA_airport_code:_"
urls = ('A'..'Z').to_a.map { |letter| base_url + letter }
file = 'airports.csv'

# write the header
File.open(file, 'w') do |f|
  f.write("IATA,ICAO,Airport Name,Location Served,Time,DST\n")
end

def add_data_to_file(table, file, tag)
  counter = 0
  File.open(file, 'a+') do |f|
    table.search('tr').each do |row|
      data = row.search('td')
      if data.size > 0
        counter += 1
        line = data.map do |datum|
          if /^\s*?\n$/.match(datum.content)
            ''
          else
            datum.content.gsub(/"/, '""')
              .gsub(/\n/, '')
              .gsub(/\[\d+\]/, '')
              .gsub(/–/, '-')
              .gsub(/UTC.{1}00:00/, 'UTC+00:00')
              .gsub(/(\w{3})-(\w{3})\d+/){"#{$1}-#{$2}"}
          end
        end
        line.map!.with_index do |x, i|
          if i == 2 || i == 3
            '"' + x + '"'
          else
            x
          end
        end
        while line.size < 6 do
          line.push('')
        end
        f.write(line.join(',') + "\n")
      end
    end
  end
  puts "#{tag}: #{counter}"
end

urls.each do |url|
  tag = /_([A-Z]{1}$)/.match(url)[1]
  doc = Nokogiri::HTML(open(url))
  # doc = Nokogiri::HTML(URI.open(url))
  table = doc.css('table.wikitable')
  add_data_to_file(table, file, tag)
end
