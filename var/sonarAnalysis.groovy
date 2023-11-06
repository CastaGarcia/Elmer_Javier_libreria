    def sonarAnalysis(Map params = [:]) {
    // Lee la variable de entorno o el valor pasado como parámetro
    def abortPipelineParam = params.abortPipeline ?: System.getenv('ABORT_PIPELINE')

    if (abortPipelineParam == 'true') {
        // Si el argumento pasado es 'true', corta siempre el pipeline
        currentBuild.result = 'FAILURE'
        error "QualityGate falló, se aborta el pipeline."
    } else {
        // Obtiene el nombre de la rama de Git de la que proviene la ejecución
        def branchName = getCurrentGitBranchName()

        if (branchName == 'main' || branchName.startsWith('hotfix')) {
            // Corta el pipeline si es la rama 'main' o una rama que comienza con 'hotfix'
            currentBuild.result = 'FAILURE'
            error "QualityGate falló, se aborta el pipeline."
        }
    }
}
def getCurrentGitBranchName() {
    // Obtiene el nombre de la rama actual desde las variables de entorno de Jenkins
    return env.BRANCH_NAME
}
sonarAnalysis() // Llama a la función sin argumentos para utilizar valores predeterminados
