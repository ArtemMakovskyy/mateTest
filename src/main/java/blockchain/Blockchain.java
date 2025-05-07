package blockchain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Blockchain {
    private List<Block> chain;
    private HashMap<String, Double> balances;

    public Blockchain() {
        this.chain = new ArrayList<>();
        this.balances = new HashMap<>();
        chain.add(new Block(new Transaction("System", "Genesis", 0), "0"));
    }

    public void addTransaction(String sender, String receiver, double amount) {
        if (balances.getOrDefault(sender, 0.0) >= amount) {
            balances.put(sender, balances.get(sender) - amount);
            balances.put(receiver, balances.getOrDefault(receiver, 0.0) + amount);
            Block previousBlock = chain.get(chain.size() - 1);
            Block newBlock = new Block(new Transaction(sender, receiver, amount), previousBlock.getHash());
            chain.add(newBlock);
        } else {
            System.out.println("Недостатньо коштів у " + sender);
        }
    }

    public void displayChain() {
        for (Block block : chain) {
            System.out.println(block);
        }
    }

    public void addBalance(String user, double amount) {
        balances.put(user, balances.getOrDefault(user, 0.0) + amount);
    }

    public void displayBalances() {
        System.out.println("Баланс користувачів: " + balances);
    }

    public static void main(String[] args) {
        Blockchain blockchain = new Blockchain();
        blockchain.addBalance("A", 100);
        blockchain.addBalance("B", 50);

        blockchain.addTransaction("A", "B", 20);
        blockchain.addTransaction("B", "C", 15);
        blockchain.addTransaction("C", "A", 10);

        blockchain.displayChain();
        blockchain.displayBalances();
    }
}