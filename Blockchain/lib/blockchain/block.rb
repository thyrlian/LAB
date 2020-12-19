require 'digest'

module LinkedCrypto
  class Block
    attr_reader :data, :hash, :previous_hash
    
    def initialize(data, previous_hash = '')
      @data = data
      @timestamp = Time.now
      @previous_hash = previous_hash
      @hash = calculate_hash
    end
    
    def link_to(block)
      @previous_hash = block.hash
      @hash = calculate_hash
    end
    
    def calculate_hash
      content = @data.to_s + @timestamp.to_s + @previous_hash.to_s
      Digest::SHA2.new(256).hexdigest(content)
    end
  end
end