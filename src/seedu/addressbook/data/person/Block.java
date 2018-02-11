package seedu.addressbook.data.person;

public class Block {
    private String blockNumber;

    public Block (String blockNumber) {
        this.blockNumber = blockNumber;
    }

    /**
     *  Returns the address block number
     *  @return blockNumber as String
     */
    @Override
    public String toString() {
        return blockNumber;
    }
}
