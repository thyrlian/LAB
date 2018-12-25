module KubernetesDemo
  module Common
    def get_machine_id
      filename = 'mid'
      machine_id = ''
      unless File.exist?(filename)
        prng = ('%04x' % "0x#{Random.new.rand(65535).to_s(16)}").upcase
        uid = `ifconfig | grep -io "\\([0-9a-f]\\{2\\}:\\)\\{5\\}\\([0-9a-f]\\{2\\}\\)" | sed 's/://g' | xargs echo | sed 's/ //g' | shasum 2>/dev/null | awk '{print $1}'`.chomp
        machine_id = uid.split('').inject({:dec => 0, :hex => '0'}) do |sum, char|
          if char.to_i.to_s == char
            sum[:dec] += char.to_i
          else
            sum[:hex] = (sum[:hex].hex + char.hex).to_s(16)
          end
          sum
        end.values.join.upcase + prng
        File.open(filename, 'w') { |f| f.write(machine_id) }
      else
        File.open(filename, 'r') do |f|
          machine_id = f.gets
        end
      end
      return machine_id
    end
    
    module_function :get_machine_id
  end
end