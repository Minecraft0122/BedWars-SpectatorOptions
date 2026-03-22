package me.kiiya.spectatoroptions.player;

import me.kiiya.spectatoroptions.SpectatorOptions;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;

public class CachedOptions {
    private final Player p;
    private Player followingPlayer;
    private Player lastFollowingPlayer;

    private boolean autoTeleport;
    private boolean nightVision;
    private boolean firstPerson;
    private boolean hideSpectators;

    private int followingTaskId;

    protected CachedOptions(Player p) {
        this.p = p;
        autoTeleport = false;
        nightVision = false;
        firstPerson = false;
        hideSpectators = false;
        followingPlayer = null;
        followingTaskId = -1;
    }

    public Player getPlayer() {
        return p;
    }

    public boolean isAutoTeleport() {
        return autoTeleport;
    }

    public void setAutoTeleport(boolean autoTeleport) {
        this.autoTeleport = autoTeleport;
    }

    public boolean isNightVision() {
        return nightVision;
    }

    public void setNightVision(boolean nightVision) {
        this.nightVision = nightVision;
    }

    public boolean isFirstPerson() {
        return firstPerson;
    }

    public void setFirstPerson(boolean firstPerson) {
        this.firstPerson = firstPerson;
    }

    public boolean isHideSpectators() {
        return hideSpectators;
    }

    public void setHideSpectators(boolean hideSpectators) {
        this.hideSpectators = hideSpectators;
    }

    @Nullable
    public Player getFollowingPlayer() {
        return followingPlayer;
    }

    public void setFollowingPlayer(Player followingPlayer) {
        this.followingPlayer = followingPlayer;
    }
    public Player getLastFollowingPlayer() {
        return lastFollowingPlayer;
    }
    public void setLastFollowingPlayer(Player lastFollowingPlayer) {
        this.lastFollowingPlayer = lastFollowingPlayer;
    }

    public int getFollowingTaskId() {
        return followingTaskId;
    }

    public void setFollowingTaskId(int followingTaskId) {
        this.followingTaskId = followingTaskId;
        if (followingTaskId == -1) {
            followingPlayer = null;
        } else {
            Bukkit.getScheduler().runTaskLater(SpectatorOptions.getInstance(), () -> {
                Bukkit.getScheduler().cancelTask(followingTaskId);
                this.followingTaskId = -1;
                followingPlayer = null;
            }, 120L);
        }
    }

    public void destroy() {
        autoTeleport = false;
        nightVision = false;
        firstPerson = false;
        hideSpectators = false;
        followingPlayer = null;
    }
}
