import React from 'react';
import { useGameStore } from '../store/gameStore';

interface StoreModalProps {
  open: boolean;
  onClose: () => void;
}

const StoreModal: React.FC<StoreModalProps> = ({ open, onClose }) => {
  const { addPet, gems, coins, addGems, addCoins } = useGameStore();

  const storeItems = [
    {
      name: 'Basic Egg',
      price: 1000,
      currency: 'coins',
      image: '🥚',
      description: 'Contains a common or uncommon pet'
    },
    {
      name: 'Royal Egg',
      price: 100,
      currency: 'gems',
      image: '🥚',
      description: 'Contains a rare or epic pet'
    },
    {
      name: 'Legendary Egg',
      price: 500,
      currency: 'gems',
      image: '🥚',
      description: 'Guaranteed legendary pet!'
    }
  ];

  if (!open) return null;

  const handlePurchase = (item: typeof storeItems[0]) => {
    if (item.currency === 'gems' && gems >= item.price) {
      addGems(-item.price);
      // Add random pet based on egg type
      const newPet = {
        id: Math.random().toString(),
        name: 'Mystery Pet',
        rarity: 'RARE',
        level: 1,
        power: 100,
        image: `https://api.dicebear.com/7.x/bottts/svg?seed=${Math.random()}`
      };
      addPet(newPet);
    } else if (item.currency === 'coins' && coins >= item.price) {
      addCoins(-item.price);
      // Add random pet based on egg type
      const newPet = {
        id: Math.random().toString(),
        name: 'Mystery Pet',
        rarity: 'COMMON',
        level: 1,
        power: 50,
        image: `https://api.dicebear.com/7.x/bottts/svg?seed=${Math.random()}`
      };
      addPet(newPet);
    }
  };

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center">
      <div className="bg-gray-800 rounded-lg p-6 max-w-2xl w-full m-4">
        <div className="flex justify-between items-center mb-6">
          <h2 className="text-2xl font-bold">🏪 Store</h2>
          <button 
            onClick={onClose}
            className="text-gray-400 hover:text-white"
          >
            ✕
          </button>
        </div>
        
        <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
          {storeItems.map((item, index) => (
            <div key={index} className="bg-gray-700 rounded-lg p-4">
              <div className="text-4xl mb-2">{item.image}</div>
              <h3 className="font-bold mb-1">{item.name}</h3>
              <p className="text-sm text-gray-400 mb-2">{item.description}</p>
              <button
                onClick={() => handlePurchase(item)}
                className="w-full bg-gradient-to-r from-purple-500 to-pink-500 px-4 py-2 rounded-lg font-bold hover:opacity-90 transition"
              >
                {item.price} {item.currency === 'gems' ? '💎' : '💰'}
              </button>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default StoreModal;