package pl.struckture;

import java.util.Scanner;

public class Quantity {
    protected int idQuantity;
    protected int sizeS = 0;
    protected int sizeM = 0;
    protected int sizeL = 0;
    protected int sizeXL = 0;
    protected int size2XL = 0;
    protected int size3XL = 0;
    protected int size4XL = 0;
    protected int size5XL = 0;
    protected int other = 0;
    protected int idMark;
    protected String mark;


    public Quantity() {
    }

    public Quantity(int idQuantity, int sizeS, int sizeM, int sizeL, int sizeXL, int size2XL, int size3XL, int size4XL, int size5XL, int other, int idMark, String mark) {
        this.idQuantity = idQuantity;
        this.sizeS = sizeS;
        this.sizeM = sizeM;
        this.sizeL = sizeL;
        this.sizeXL = sizeXL;
        this.size2XL = size2XL;
        this.size3XL = size3XL;
        this.size4XL = size4XL;
        this.size5XL = size5XL;
        this.other = other;
        this.idMark = idMark;
        this.mark = mark;
    }

    public Quantity setQuantity() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj ile sztuk rozmiaru S chcesz");
        int sizeS = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj ile sztuk rozmiaru M chcesz");
        int sizeM = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj ile sztuk rozmiaru L chcesz");
        int sizeL = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj ile sztuk rozmiaru XL chcesz");
        int sizeXL = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj ile sztuk rozmiaru XXL chcesz");
        int size2XL = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Podaj marke");
        String mark = scanner.nextLine();
        Quantity quantity = new Quantity();

        return quantity;

    }

    public int getIdQuantity() {
        return idQuantity;
    }

    public int getSizeS() {
        return sizeS;
    }

    public int getSizeM() {
        return sizeM;
    }

    public int getSizeL() {
        return sizeL;
    }

    public int getSizeXL() {
        return sizeXL;
    }

    public int getSize2XL() {
        return size2XL;
    }

    public int getSize3XL() {
        return size3XL;
    }

    public int getSize4XL() {
        return size4XL;
    }

    public int getSize5XL() {
        return size5XL;
    }

    public int getOther() {
        return other;
    }

    public String getMark() {
        return mark;
    }

    @Override
    public String toString() {
        String normalOrder;
        String hightOrder;
        String otherOrder;
        if (other == 0 && size4XL == 0) {
            return normalOrder = "sizeS=" + sizeS +
                    ", sizeM=" + sizeM +
                    ", sizeL=" + sizeL +
                    ", sizeXL=" + sizeXL +
                    ", size2XL=" + size2XL +
                    ", size3XL=" + size3XL + "sztuk " + mark;
        }
        else if (other != 0) {
            return otherOrder = other + " sztuk " + mark;
        }
       else if (other == 0 && sizeS == 0) {
            return hightOrder = "sizeXL=" + sizeXL +
                    ", size2XL=" + size2XL +
                    ", size3XL=" + size3XL +
                    ", size4XL=" + size4XL +
                    ", size5XL=" + size5XL +
                    " sztuk " + mark;
        }
        else return "upss";
    }
}
