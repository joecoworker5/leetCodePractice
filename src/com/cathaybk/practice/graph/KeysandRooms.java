package com.cathaybk.practice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeysandRooms {

	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		rooms.add(Arrays.asList(1, 3));
		rooms.add(Arrays.asList(3, 0, 1));
		rooms.add(Arrays.asList(2));
		rooms.add(Arrays.asList(0));

		boolean canVisitAllRooms = new KeysandRooms().canVisitAllRooms(rooms);
		System.out.println(canVisitAllRooms);
	}

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int roomNum = rooms.size();
		if (roomNum == 1) {
			return true;
		}
		List<Integer> firstRoomKeys = rooms.get(0);
		boolean[] initial = new boolean[roomNum];
		initial[0] = true;
		dfs(rooms, firstRoomKeys, initial);
		return areAllTrue(initial);

	}

	void dfs(List<List<Integer>> rooms, List<Integer> roomKeys, boolean[] opened) {

		for (int i = 0; i < roomKeys.size(); i++) {
			Integer otherRoom = roomKeys.get(i);
			if (opened[otherRoom])
				continue;

			opened[otherRoom] = true;
			List<Integer> otherRoomKeys = rooms.get(otherRoom);
			dfs(rooms, otherRoomKeys, opened);

		}

	}

	public boolean areAllTrue(boolean[] array) {
		for (boolean b : array)
			if (!b)
				return false;
		return true;
	}
}
