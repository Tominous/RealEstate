package me.EtienneDx.RealEstate;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import me.EtienneDx.RealEstate.Transactions.BoughtTransaction;
import me.EtienneDx.RealEstate.Transactions.Transaction;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.IRealEstate;

public class GP_RealEstateHook implements IRealEstate
{
	@Override
	public String allowEdit(Claim claim, Player player)
	{
		Transaction b = RealEstate.transactionsStore.getTransaction(claim);
		if(b != null && b.getOwner().equals(player.getUniqueId()) && b instanceof BoughtTransaction)
		{
			if(((BoughtTransaction)b).getBuyer() != null)
				return "This claim is currently involved in a transaction, you can't edit it!";
		}
		return null;
	}

	@Override
	public String allowBuild(Claim claim, Player player, Material material)
	{
		Transaction b = RealEstate.transactionsStore.getTransaction(claim);
		if(b != null && b.getOwner().equals(player.getUniqueId()) && b instanceof BoughtTransaction)
		{
			if(((BoughtTransaction)b).getBuyer() != null)
				return "This claim is currently involved in a transaction, you can't build on it!";
		}
		return null;
	}

	@Override
	public String allowAccess(Claim claim, Player player)
	{
		Transaction b = RealEstate.transactionsStore.getTransaction(claim);
		if(b != null && b.getOwner().equals(player.getUniqueId()) && b instanceof BoughtTransaction)
		{
			if(((BoughtTransaction)b).getBuyer() != null)
				return "This claim is currently involved in a transaction, you can't access it!";
		}
		return null;
	}

	@Override
	public String allowContainers(Claim claim, Player player)
	{
		Transaction b = RealEstate.transactionsStore.getTransaction(claim);
		if(b != null && b.getOwner().equals(player.getUniqueId()) && b instanceof BoughtTransaction)
		{
			if(((BoughtTransaction)b).getBuyer() != null)
				return "This claim is currently involved in a transaction, you can't access it's containers!";
		}
		return null;
	}

	@Override
	public String allowGrantPermission(Claim claim, Player player)
	{
		Transaction b = RealEstate.transactionsStore.getTransaction(claim);
		if(b != null && b instanceof BoughtTransaction)
		{
			if(((BoughtTransaction)b).getBuyer() != null)
				return "This claim is currently involved in a transaction, you can't change any permission!";
		}
		return null;
	}

	@Override
	public boolean anyTransaction(Claim claim)
	{
		return RealEstate.transactionsStore.anyTransaction(claim);
	}
}
