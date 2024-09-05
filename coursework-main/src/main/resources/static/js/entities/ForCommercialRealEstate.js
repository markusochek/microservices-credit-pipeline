export class ForCommercialRealEstate {
    typeOfRepayment;
    postponement;
constructor(typeOfRepayment, postponement) {
        this.typeOfRepayment = typeOfRepayment || null;
        this.postponement = postponement || null;
    }

    getLabels() {
        return ["вид погашения", "отсрочка"];
    }
}