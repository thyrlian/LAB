module KubernetesDemo
  class App < Sinatra::Base
    register Sinatra::Namespace
    
    before do
      headers 'Charset' => 'utf-8', 'X-Machine-Id' => settings.machine_id
    end
    
    # APIs
    # ==================================================
    namespace '/api' do
      get '/status/?' do
        content_type :json
        {'message' => "I am alive! (#{Time.now})"}.to_json
      end
      
      get '/hi/?' do
        "Hello from #{settings.machine_id}"
      end
    end
  end
end