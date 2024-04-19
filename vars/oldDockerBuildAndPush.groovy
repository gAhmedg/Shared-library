def call(Map config = [:]) {
  sh "docker build --tag ${config.imageName} ."
  echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin
  sh "docker push ${config.imageName}"
}