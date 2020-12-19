require_relative 'block'

module LinkedCrypto
  class Blockchain
    attr_reader :list
    
    def initialize
      @list = []
    end
    
    def get_last_block
      @list.last
    end
    
    def add_block(block)
      unless @list.empty?
        block.link_to(get_last_block)
      end
      @list.push(block)
      self
    end
    
    def is_valid
      validity = true
      for i in 1...@list.size do
        block = @list[i]
        previous_block = @list[i - 1]
        if block.previous_hash != previous_block.hash || block.hash != block.calculate_hash
          validity = false
          p block
          break
        end
      end
      validity
    end
    
    def inspect
      list.inject('') { |output, block| output += block.inspect + "\n" }
    end
  end
end