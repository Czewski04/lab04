package model;

public class DatabaseRow {
    int rowNumber;
    String nameVar;
    String nameSection;
    String nameDimension1;
    String nameDimension2;
    String nameDimension3;
    String namePosition1;
    String namePosition2;
    String namePosition3;
    //String period;
    float value;

    public DatabaseRow(int rowNumber, String nameVar, String nameSection, String nameDimension1, String nameDimension2, String nameDimension3,
                       String namePosition1, String namePosition2, String namePosition3, float value) {
        this.rowNumber = rowNumber;
        this.nameVar = nameVar;
        this.nameSection = nameSection;
        this.nameDimension1 = nameDimension1;
        this.nameDimension2 = nameDimension2;
        this.nameDimension3 = nameDimension3;
        this.namePosition1 = namePosition1;
        this.namePosition2 = namePosition2;
        this.namePosition3 = namePosition3;
        this.value = value;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public String getNameVar() {
        return nameVar;
    }

    public String getNameSection() {
        return nameSection;
    }

    public String getNameDimension1() {
        return nameDimension1;
    }

    public String getNameDimension2() {
        return nameDimension2;
    }

    public String getNameDimension3() {
        return nameDimension3;
    }

    public String getNamePosition1() {
        return namePosition1;
    }

    public String getNamePosition2() {
        return namePosition2;
    }

    public String getNamePosition3() {
        return namePosition3;
    }

    public float getValue() {
        return value;
    }
}