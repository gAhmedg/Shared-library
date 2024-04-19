def call(Map config) {
  def containerId = (env.JOB_NAME+env.BUILD_NUMBER).toLowerCase()
  
  sh """
    #Build the image
    docker build --tag ${config.imageName} .

    #login before  pushing to registry if required
    echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin

    #push images to registery
    docker push ${config.imageName}

  """




 if (dockerBuildAndPush( imageName: "", port : "")) {
                echo 'push'
            } else {
                echo 'I execute elsewhere'
            }  
/*
dockerBuildAndPush( imageName: "", port : "")
*/