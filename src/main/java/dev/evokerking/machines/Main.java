package dev.evokerking.machines;

import com.hypixel.hytale.event.EventRegistry;
import com.hypixel.hytale.logger.HytaleLogger;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.plugin.PluginManager;
import dev.evokerking.machines.commands.machines;

import javax.annotation.Nonnull;
import java.util.logging.Level;

public class Main extends JavaPlugin {

    public static final HytaleLogger LOGGER = HytaleLogger.forEnclosingClass();

    private static Main instance;

    public Main(@Nonnull JavaPluginInit init) {
        super(init);
        instance = this;
    }

    /**
     * Get the plugin instance.
     * @return The plugin instance
     */
    public static Main getInstance() {
        return instance;
    }

    @Override
    protected void start() {
        LOGGER.at(Level.INFO).log("[Evoker Machines - Start] Starting Evoker Machines!");
    }

    @Override
    protected void setup() {
        LOGGER.at(Level.INFO).log("[Evoker Machines - Setup]: Setting Up Evoker Machines!");

        LOGGER.at(Level.INFO).log("[Evoker Machines - Setup]: Registering commands and listeners!");

        /**
         * Register the commands and listeners here
         * these then contain the result of the register methods
         **/
        boolean commandsRegistered = registerCommands();
        boolean listenersRegistered = registerListeners();


        if (commandsRegistered && listenersRegistered) {
            LOGGER.at(Level.INFO).log("[Evoker Machines - Setup] Successfully setup commands and listeners!");
        } else {
            LOGGER.at(Level.SEVERE).log("[Evoker Machines - Setup] Failed to setup commands and listeners! disabling now.");
            PluginManager.get().unload(getIdentifier());
        }


    }

    @Override
    protected void shutdown() {
        LOGGER.at(Level.INFO).log("[Evoker Machiness - Shutdown] Shutting down Evoker Machines!");
        instance = null;
    }

    /**
     *
     * @return boolean - Indicates if it was successful or not, true = success, false = failure
     * **/
    private boolean registerCommands() {
        try {
            /**
             * Register All new commands here
             **/

            getCommandRegistry().registerCommand(new machines());

            return true;
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[EvokerMachines - Setup] Failed to register commands!!");
            return false;
        }
    }

    /**
     *
     * @return boolean - Indicates if it was successful or not, true = success, false = failure
     * **/
    private boolean registerListeners() {
        EventRegistry bus = getEventRegistry();

        try {
            /**
             * Register All new listeners here
             **/

            return true;
        } catch (Exception e) {
            LOGGER.at(Level.WARNING).withCause(e).log("[EvokerMachines - Setup] Failed to register listeners!!");
            return false;
        }
    }
}
