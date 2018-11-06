package  appl;


public abstract class Calculator {
    protected String x;
    protected String filename;

    public abstract  void SaveToFile();
    public abstract  String Add();
    public abstract  void Subtract();
    public abstract void Multiply();
}
