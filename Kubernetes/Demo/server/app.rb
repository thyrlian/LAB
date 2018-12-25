require 'sinatra/base'
require 'sinatra/contrib'

require_relative 'routes/init'
require_relative 'helpers/common'

module KubernetesDemo
  class App < Sinatra::Base
    configure do
      root_dir = File.dirname(__FILE__)
      set :root, root_dir
      set :app_file, File.join(root_dir, File.basename(__FILE__))
      set :bind, '0.0.0.0'
      set :port, 80
      set :machine_id, Common.get_machine_id
      register Sinatra::Namespace
      helpers Sinatra::JSON
    end
  end
end
