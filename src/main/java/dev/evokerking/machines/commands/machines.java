package dev.evokerking.machines.commands;

import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractCommandCollection;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.Message;

import javax.annotation.Nonnull;

/**
 * machines - Command collection for /.
 * <p>
 * Usage:
 * - / help - Show available commands
 */
public class machines extends AbstractCommandCollection {

    public machines() {
        super("machines", "machines");
        this.addSubCommand(new HelpSubCommand());
        this.addSubCommand(new uiSubCommand());
    }

    /**
     * / help - Show available commands
     */
    private static class HelpSubCommand extends CommandBase {

        public HelpSubCommand() {
            super("help", "Show available commands");
        }


        @Override
        protected void executeSync(@Nonnull CommandContext context) {
            context.sendMessage(Message.raw(""));
            context.sendMessage(Message.raw("===  Commands ==="));
            context.sendMessage(Message.raw("/ help - Show this help message"));
            context.sendMessage(Message.raw("========================"));
        }
    }


}
