package com.bnegames.minecraft;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class HomeRecallCommand implements ICommand
{ 
    private final List aliases;
  
    public HomeRecallCommand() 
    { 
        aliases = new ArrayList(); 
        aliases.add("ph"); 
    } 
  
    @Override 
    public String getName() 
    { 
        return "phonehome"; 
    }

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "phonehome";
	}

	@Override
	public List<String> getAliases() {
		return aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		World world = sender.getEntityWorld(); 
	    
        if (world.isRemote) 
        { 
            System.out.println("Not processing on Client side"); 
        } 
        else 
        { 
            System.out.println("Processing on Server side"); 
            if(args.length == 0) 
            { 
                System.err.println("Invalid argument"); 
                return; 
            } 
    
            sender.sendMessage(new TextComponentString(".. some message ..")); 
     
            world.setSpawnPoint(sender.getPosition());
        } 
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		// let everyone do this for now.
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
			BlockPos targetPos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	} 

}