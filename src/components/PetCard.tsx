import React from 'react';
import { Pet } from '../types';

interface PetCardProps {
  pet: Pet;
}

const rarityColors = {
  COMMON: 'bg-gray-500',
  UNCOMMON: 'bg-green-500',
  RARE: 'bg-blue-500',
  EPIC: 'bg-purple-500',
  LEGENDARY: 'bg-yellow-500',
  GODLY: 'bg-red-500'
};

const PetCard: React.FC<PetCardProps> = ({ pet }) => {
  return (
    <div className="bg-gray-800 rounded-lg p-4 shadow-lg hover:transform hover:scale-105 transition">
      <div className="relative">
        <img 
          src={pet.image} 
          alt={pet.name}
          className="w-full h-32 object-contain mb-2"
        />
        <span className={`absolute top-0 right-0 ${rarityColors[pet.rarity]} px-2 py-1 rounded-bl-lg text-xs font-bold`}>
          {pet.rarity}
        </span>
      </div>
      <h3 className="font-bold text-lg mb-1">{pet.name}</h3>
      <div className="flex justify-between text-sm">
        <span>Level {pet.level}</span>
        <span>Power: {pet.power}</span>
      </div>
    </div>
  );
};

export default PetCard;