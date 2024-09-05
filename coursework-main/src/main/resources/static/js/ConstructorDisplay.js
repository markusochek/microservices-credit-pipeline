import {Enumerations} from "./enumerations/Enumerations.js";
import {jsDatepicker} from "./newAnalysis/jsDatepicker.js";

export class ConstructorDisplay {
    static NUMBERS_OF_COLUMNS = 36;
    static NUMBERS_OF_ROWS = 36;

    static pageHTML;
    static numberOfColumns;
    static numberOfRows;

    static {
        ConstructorDisplay.pageHTML = document.createElement("pageHTML");
        ConstructorDisplay.pageHTML.className = "container";
        document.body.append(ConstructorDisplay.pageHTML);

        ConstructorDisplay.numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS
        ConstructorDisplay.numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS
    }

    static setColumnsRows(numberOfColumns, numberOfRows) {
        ConstructorDisplay.numberOfColumns = numberOfColumns;
        ConstructorDisplay.numberOfRows = numberOfRows;

        ConstructorDisplay.pageHTML.style.gridTemplateColumns = `repeat(${numberOfColumns}, 1fr)`;
        ConstructorDisplay.pageHTML.style.gridTemplateRows = `repeat(${numberOfRows}, 1fr)`;
    }

    static showObject(object) {
        let i = 0;
        let labels = object.getLabels();

        for (const objectKey in object) {
            if(typeof object[objectKey] != 'function') {
                let div = document.createElement("div");
                div.className = `box`;
                if (object.hasOwnProperty("span")) {
                    div.style.gridColumn = `span ${ConstructorDisplay.numberOfColumns / object.span()}`;
                } else {
                    div.style.gridColumn = `span ${ConstructorDisplay.numberOfColumns / Object.keys(object).length}`;
                }
                ConstructorDisplay.pageHTML.append(div);

                let label = document.createElement("label");
                label.innerHTML = labels[i];
                div.append(label);

                let purifiedObjectKey = objectKey.replace(/[0-9]/g, '')
                let enumeration = Enumerations.getEnumeration(purifiedObjectKey);
                if (enumeration) {
                    Enumerations.showEnumeration(div, enumeration);
                } else if (typeof object[objectKey] === "boolean") {
                    let select = document.createElement("select");

                    let option = document.createElement("option");
                    option.value = "false";
                    option.textContent = "Нет";
                    select.append(option);

                    option = document.createElement("option");
                    option.value = "true";
                    option.textContent = "Да";
                    select.append(option);

                    div.append(select);

                } else {
                    let input = document.createElement("input");
                    input.placeholder = labels[i];
                    input.value = object[objectKey];
                    div.append(input);
                    if (objectKey === "version" || objectKey === "date" || objectKey.startsWith("dateOfBirth")) {
                        jsDatepicker(input);
                        input.value = object[objectKey].toLocaleDateString();
                    }
                }
                ++i;
            }
        }
    }

    static showButton(innerText, onclick, numberOfElements) {
        let div = document.createElement("div");
        div.className = `box`;
        div.style.gridColumn = `span ${ConstructorDisplay.numberOfColumns / numberOfElements}`;

        let button = document.createElement("button");
        button.innerText = innerText;
        button.onclick = onclick;
        div.append(button);
        ConstructorDisplay.pageHTML.append(div);
    }

    static wrapObjects(objects) {
        let keys = {}
        let bodyObject = {};
        let k = 0;
        for (const objectsKey in objects) {
            let object = objects[objectsKey]
            keys[objectsKey] = [];
            for (const objectKey in object) {
                if(typeof object[objectKey] != 'function') {
                    keys[objectsKey].push(objectKey);
                }
            }
            k++;
        }
        let childNodes = ConstructorDisplay.pageHTML.childNodes;
        let i = 0;
        for (const keyKey in keys) {
            bodyObject[keyKey] = {}
            for (let j = 0; j < keys[keyKey].length;) {
                if (childNodes[i].childNodes[0].nodeName !== 'BUTTON') {
                    let purifiedObjectKey = keys[keyKey][j].replace(/[0-9]/g, '')
                    let enumeration = Enumerations.getEnumeration(purifiedObjectKey);
                    if (enumeration) {
                        bodyObject[keyKey][keys[keyKey][j]] =
                            Enumerations.getKeyByValue(enumeration, childNodes[i].childNodes[1].value);
                    } else {
                        bodyObject[keyKey][keys[keyKey][j]] = childNodes[i].childNodes[1].value;
                    }
                    j++;
                }
                i++;
            }
        }
        return bodyObject;
    }
}