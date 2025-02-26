def call(String repoUrl, String branch) {
    echo "Cloning The Co.de"
    git url: repoUrl, branch: branch
    echo "Cloning The Code Successfully."
}
