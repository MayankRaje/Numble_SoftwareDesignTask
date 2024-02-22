public enum PassengerType {
    standardPasssenger {
        @Override
        public boolean checkBalance(int balance, int price) {
            return balance - price < 0;
        }
    },
    goldPassenger {
        @Override
        public boolean checkBalance(int balance, int price) {
            double discountedPrice = price*0.9;
            int priceToPay = (int)discountedPrice;
            return balance - priceToPay < 0;
        }
    },
    standardPassenger {
        @Override
        public boolean checkBalance(int balance, int price) {
            // NO PRICE INVOLVED!
            return false;
        }
    };
    public abstract boolean checkBalance(int balance, int price);
}