void main() {
    double principal = 17000;
    double rate = 0.07;
    double interest;

    interest = principal * rate;
    principal = principal + interest;

    println("Interest            = " + interest);
    println("Amount after 1 year = " + principal);
}