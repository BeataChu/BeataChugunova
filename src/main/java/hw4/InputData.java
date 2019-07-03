package hw4;

import hw4.enums.values_for_data_input.Colors;
import hw4.enums.values_for_data_input.Elements;
import hw4.enums.values_for_data_input.Metals;
import hw4.enums.values_for_data_input.Vegetables;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class InputData {

    private Colors colors;
    private List<Elements> elements;
    private Metals metals;
    private List<Integer> summary;
    private List<Vegetables> vegetables;

//    protected static Builder builder;
//
//    private InputData() {

}

//    public List<Integer> getSummary() {
//        return summary;
//    }
//
//    public List<Elements> getElements() {
//        return elements;
//    }
//
//    public Colors getColors() {
//        return colors;
//    }
//
//    public Metals getMetals() {
//        return metals;
//    }
//
//    public List<Vegetables> getVegetables() {
//        return vegetables;
//    }
//
//    public static Builder getBuilder() {
//        return new Builder();
//    }
//
//    public static class Builder {
//
//        private Colors colors;
//        private List<Elements> elements;
//        private Metals metals;
//        private List<Integer> summary;
//        private List<Vegetables> vegetables;
//
//        private Builder() {
//        }
//
//        public Builder setSummary(List<Integer> summary) {
//            this.summary = summary;
//            return this;
//        }
//
//        public Builder setElements(List<Elements> elements) {
//            this.elements = elements;
//            return this;
//        }
//
//        public Builder setColors(Colors colors) {
//            this.colors = colors;
//            return this;
//        }
//
//        public Builder setMetals(Metals metals) {
//            this.metals = metals;
//            return this;
//        }
//
//        public Builder setVegetables(List<Vegetables> vegetables) {
//            this.vegetables = vegetables;
//            return this;
//        }
//
//        public InputData build() {
//            InputData inputData = new InputData();
//            inputData.colors = this.colors;
//            inputData.elements = this.elements;
//            inputData.metals = this.metals;
//            inputData.summary = this.summary;
//            inputData.vegetables = this.vegetables;
//            return inputData;
//        }
//    }
//
//
//}

