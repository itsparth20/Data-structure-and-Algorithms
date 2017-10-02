class Geometry implements Rectangle, Circle{
    public int area(int height, int width){
        return height*width;
    }
    public double area(int radius){
        return 3.14*radius*radius;
    }
}

