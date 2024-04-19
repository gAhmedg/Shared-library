def call(Map config) {
  
  
  sh """
    #Build the image
    docker build --tag ${config.imageName} .

    #login before  pushing to registry if required
    echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin

    #push images to registery
    docker push ${config.imageName}
    docker logout

  """




 
/*
dockerBuildAndPush( imageName: "", port : "")
*/