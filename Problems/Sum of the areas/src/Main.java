class Sum {
    public static int sumOfAreas(Shape[] array) {
        int sumOfAreas = 0;
        for (Shape shape : array) {
            if (shape instanceof Square) {
                sumOfAreas += ((Square) shape).getSide() * ((Square) shape).getSide();
            } else if (shape instanceof Rectangle) {
                sumOfAreas += ((Rectangle) shape).getHeight() * ((Rectangle) shape).getWidth();
            } else {
                sumOfAreas += 0;
            }
        }
        return sumOfAreas;
    }
}

//Don't change the code below
class Shape {
}

class Square extends Shape {
    private int side;

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}