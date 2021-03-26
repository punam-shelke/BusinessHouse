package cell;

public enum InputCell {
    L {
        @Override
        public Cell getCell() {
            return new Lottery();
        }
    }, H {
        @Override
        public Cell getCell() {
            return new Hotel();
        }
    }, J {
        @Override
        public Cell getCell() {
            return new Jail();
        }
    }, E {
        @Override
        public Cell getCell() {
            return new Empty();
        }
    };

    public abstract Cell getCell();
}
