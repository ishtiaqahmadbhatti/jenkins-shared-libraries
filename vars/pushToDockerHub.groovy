def call(String credentialsId, String dockerHubUser, String dockerHubPass, String imageName) {
    withCredentials([usernamePassword(
        credentialsId: credentialsId,
        usernameVariable: "dockerHubUser", 
        passwordVariable: "dockerHubPass")]) {
        sh "docker login -u ${env.dockerHubUser} -p ${env.dockerHubPass}"
        sh "docker image tag ${imageName}:latest ${env.dockerHubUser}/${imageName}:latest"
        sh "docker push ${env.dockerHubUser}/${imageName}:latest"
    }
}
