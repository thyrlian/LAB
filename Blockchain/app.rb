require_relative 'lib/blockchain'

include LinkedCrypto

blockchain = Blockchain.new
blockchain.add_block(Block.new('Genesis Block'))
          .add_block(Block.new('2nd'))
          .add_block(Block.new('3rd'))
          .add_block(Block.new('4th'))
          .add_block(Block.new('5th'))
          .add_block(Block.new('6th'))
p blockchain

puts blockchain.is_valid
tampered_block = blockchain.list[4]
tampered_block.instance_variable_set(:@data, '$$$$$$$$$$ Billionaire $$$$$$$$$$')
puts blockchain.is_valid
tampered_block.instance_variable_set(:@hash, tampered_block.calculate_hash)
puts blockchain.is_valid
