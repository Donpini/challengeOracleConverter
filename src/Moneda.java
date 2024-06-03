package src;

public record Moneda(String base_code
        ,String target_code
        ,Double conversion_rate
        ,Double conversion_result) {



    @Override
    public Double conversion_result() {
        return conversion_result;
    }



    @Override
    public Double conversion_rate() {
        return conversion_rate;
    }
}
