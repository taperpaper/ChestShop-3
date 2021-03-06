package com.Acrobot.ChestShop.Events.Economy;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.math.BigDecimal;

/**
 * Represents a transaction of goods between two entities
 *
 * @author Acrobot
 */
public class CurrencyTransferEvent extends Event {
    private static final HandlerList handlers = new HandlerList();

    private BigDecimal amount;
    private World world;
    private String sender;
    private String receiver;

    public CurrencyTransferEvent(BigDecimal amount, String sender, String receiver, World world) {
        this.amount = amount;
        this.world = world;

        this.sender = sender;
        this.receiver = receiver;
    }

    public CurrencyTransferEvent(double amount, String sender, String receiver, World world) {
        this(BigDecimal.valueOf(amount), sender, receiver, world);
    }

    /**
     * @return Amount of currency
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @return Amount of currency, as a double
     * @deprecated Use {@link #getAmount()} if possible
     */
    public double getDoubleAmount() {
        return amount.doubleValue();
    }

    /**
     * Sets the amount of currency transferred
     *
     * @param amount Amount to transfer
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Sets the amount of currency transferred
     *
     * @param amount Amount to transfer
     * @deprecated Use {@link #setAmount(java.math.BigDecimal)} if possible
     */
    public void setAmount(double amount) {
        this.amount = BigDecimal.valueOf(amount);
    }

    /**
     * @return The world in which the transaction occurs
     */
    public World getWorld() {
        return world;
    }

    /**
     * @return Sender of the money
     */
    public String getSender() {
        return sender;
    }

    /**
     * @return Receiver of the money
     */
    public String getReceiver() {
        return receiver;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
