node {

    checkout scm
    sh "cd product"
    sh "ls"
    sh "cd 'product'"
    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub') {

        def customImage = docker.build("newscape/demoproduct")

        /* Push the container to the custom Registry */
        customImage.push()
    }
}
