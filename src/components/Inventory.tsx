import React from 'react';
import { useGameStore } from '../store/gameStore';

const Inventory: React.FC = () => {
  const { pets } = useGameStore();

  return (
    <section>
      <h2 className="text-2xl font-bold mb-4">Inventory</h2>
      <div className="bg-gray-800 rounded-lg p-4">
        <div className="grid grid-cols-2 gap-4">
          <div>
            <h3 className="font-bold mb-2">Statistics</h3>
            <ul className="space-y-2">
              <li>Total Pets: {pets.length}</li>
              <li>Legendary Pets: {pets.filter(p => p.rarity === 'LEGENDARY').length}</li>
              <li>Highest Power: {Math.max(...pets.map(p => p.power))}</li>
            </ul>
          </div>
          <div>
            <h3 className="font-bold mb-2">Achievements</h3>
            <ul className="space-y-2">
              <li>🏆 Pet Collector</li>
              <li>🌟 First Legendary</li>
              <li>💪 Power Master</li>
            </ul>
          </div>
        </div>
      </div>
    </section>
  );
};

export default Inventory;