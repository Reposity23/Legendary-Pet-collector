import { create } from 'zustand';
import { Pet } from '../types';

interface GameState {
  player: {
    username: string;
    avatar: string | null;
  };
  pets: Pet[];
  gems: number;
  coins: number;
  openStore: boolean;
  setOpenStore: (open: boolean) => void;
  addPet: (pet: Pet) => void;
  addGems: (amount: number) => void;
  addCoins: (amount: number) => void;
}

export const useGameStore = create<GameState>((set) => ({
  player: {
    username: 'Player',
    avatar: null,
  },
  pets: [
    {
      id: '1',
      name: 'Baby Dragon',
      rarity: 'RARE',
      level: 1,
      power: 100,
      image: 'https://api.dicebear.com/7.x/bottts/svg?seed=dragon'
    },
    {
      id: '2',
      name: 'Phoenix',
      rarity: 'LEGENDARY',
      level: 1,
      power: 250,
      image: 'https://api.dicebear.com/7.x/bottts/svg?seed=phoenix'
    }
  ],
  gems: 1000,
  coins: 5000,
  openStore: false,
  setOpenStore: (open) => set({ openStore: open }),
  addPet: (pet) => set((state) => ({ pets: [...state.pets, pet] })),
  addGems: (amount) => set((state) => ({ gems: state.gems + amount })),
  addCoins: (amount) => set((state) => ({ coins: state.coins + amount })),
}));