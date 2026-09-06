package dev.evokerking.machines.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import dev.evokerking.machines.ui.testUi;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;

public class uiSubCommand extends AbstractPlayerCommand {

    public uiSubCommand() {
        super("ui-test", "Opens the test UI");
        this.addAliases("ui");
    }
    @Override
    protected void execute(@Nonnull CommandContext context,
                           @Nonnull Store<EntityStore> store,
                           @Nonnull Ref<EntityStore> ref,
                           @Nonnull PlayerRef playerRef,
                           @Nonnull World world
    ) {
        context.sendMessage(Message.raw("Opening test Dashboard..."));

        try {
            // Get the player component (safe - we're on world thread)
            Player player = store.getComponent(ref, Player.getComponentType());
            if (player == null) {
                context.sendMessage(Message.raw("Error: Could not get Player component."));
                return;
            }

            // Create and open the custom page
            testUi dashboardPage = new testUi(playerRef);
            player.getPageManager().openCustomPage(ref, store, dashboardPage);
            context.sendMessage(Message.raw("Dashboard opened. Press ESC to close."));
        } catch (Exception e) {
            context.sendMessage(Message.raw("Error opening dashboard: " + e.getMessage()));
        }
    }
}
