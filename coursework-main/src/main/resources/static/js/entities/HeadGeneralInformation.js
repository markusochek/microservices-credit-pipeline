export class HeadGeneralInformation {
    version
    analysisStatus
    view

    constructor(version, analysisStatus, view) {
        this.version = version || new Date();
        this.analysisStatus = analysisStatus || null;
        this.view = view || null;
    }

    getLabels() {
        return ["Версия", "Статус анализа", "Вид"];
    }
}