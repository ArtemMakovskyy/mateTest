package blockchain;

class Block {
    private String previousHash;
    private Transaction data;
    private String hash;

    public Block(Transaction data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash = generateHash();
    }

    public String generateHash() {
        return Integer.toHexString((data.toString() + previousHash).hashCode());
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "previousHash='" + previousHash + '\'' +
                ", data=" + data +
                ", hash='" + hash + '\'' +
                '}';
    }
}