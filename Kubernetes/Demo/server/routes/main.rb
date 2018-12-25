module KubernetesDemo
  class App < Sinatra::Base
    register Sinatra::Namespace
    
    before do
      headers 'Charset' => 'utf-8', 'X-Machine-Id' => settings.machine_id
    end
    
    namespace '/' do
      get '/?' do
        'κῠβερνήτης (kubernḗtēs): a captain, a steersman, a pilot, a navigator.'
      end
    end
  end
end