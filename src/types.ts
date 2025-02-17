export interface Pet {
  id: string;
  name: string;
  rarity: 'COMMON' | 'UNCOMMON' | 'RARE' | 'EPIC' | 'LEGENDARY' | 'GODLY';
  level: number;
  power: number;
  image: string;
}