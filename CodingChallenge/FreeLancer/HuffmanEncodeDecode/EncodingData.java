
/*
This class will help to generate encoding data.
Class has two instance variable, one symbol character and
encoding string that represent that symbol.
 */
public class EncodingData {
        //two instance variable
        private char symbol;
        private String encoding;

        //constructor to initialize the object
        public EncodingData(char symbol, String encoding) {
            this.symbol = symbol;
            this.encoding = encoding;
        }

        //getter and setter
        public char getSymbol() {
            return symbol;
        }
    
        public void setSymbol(char symbol) {
            this.symbol = symbol;
        }
    
        public String getEncoding() {
            return encoding;
        }
    
        public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        //equal method to compare two object
        public boolean equals(Object obj) {
    
            EncodingData other = (EncodingData) obj;
            if (symbol != other.symbol)
                return false;
            return true;
        }

        @Override
        public String toString() {
            return "EncodingData{" +
                    "symbol=" + symbol +
                    ", encoding='" + encoding + '\'' +
                    '}';
        }
    }