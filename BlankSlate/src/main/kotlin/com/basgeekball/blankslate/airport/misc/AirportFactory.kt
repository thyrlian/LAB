package com.basgeekball.blankslate.airport.misc

import com.basgeekball.blankslate.airport.model.Airport
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import java.io.File
import java.io.FileReader
import java.io.Reader
import java.net.URL

class AirportFactory {
    companion object {
        val CSV_FILE = "airports.csv"
        val HEADERS = arrayOf("IATA", "ICAO", "Airport Name", "Location Served", "Time", "DST")

        private fun parse(csvFile: String): Iterable<CSVRecord> {
            val resource: URL = this::class.java.classLoader.getResource(csvFile)
                ?: throw IllegalArgumentException("File not found: $csvFile")
            val reader: Reader = FileReader(File(resource.toURI()))
            val csvFormat: CSVFormat = CSVFormat.Builder.create()
                .setHeader(*HEADERS)
                .setSkipHeaderRecord(true)
                .build()
            return csvFormat.parse(reader)
        }

        private fun convert(records: Iterable<CSVRecord>): ArrayList<Airport> {
            val airports: ArrayList<Airport> = ArrayList()
            for (record in records) {
                val iata = record["IATA"]
                val icao = record["ICAO"]
                val name = record["Airport Name"]
                val location = record["Location Served"]
                val time = record["Time"]
                val dst = record["DST"]
                airports.add(Airport(iata, icao, name, location, time, dst))
            }
            return airports
        }

        fun build(): ArrayList<Airport> {
            return convert(parse(CSV_FILE))
        }
    }
}