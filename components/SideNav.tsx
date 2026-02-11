'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { Home, Flame, Code2, User, Info } from 'lucide-react';
import Lottie from 'lottie-react';
import { useEffect, useState } from 'react';

const navItems = [
  { name: 'Home', href: '/', icon: Home },
  { name: 'Streak', href: '/streak', icon: Flame },
  { name: 'All Codes', href: '/codes', icon: Code2 },
  { name: 'About', href: '/about', icon: Info },
  { name: 'Profile', href: '/profile', icon: User },
];

// Fun animations for the sidebar footer
// All available animations from public/animations folder
const animationFiles = [
  '3D Chef Dancing.json',
  'All-India Delivery.json',
  'Appointment booking with smartphone.json',
  'Artman4.json',
  'Boxing with Bone - Angry Puppy.json',
  'Boxing, Kickboxing, Fight, Pow Animation.json',
  'Burger Lottie Animation..json',
  'Burpee and Jump Exercise.json',
  'Bus Transport.json',
  'Car driving on road.json',
  'Car loading.json',
  'Car.json',
  'Cat Pookie.json',
  'Cat fishing on moon.json',
  'Cat playing animation.json',
  'Cat typing.json',
  'Cat_in_Box.json',
  'CoffeeTea.json',
  'Congratulation | Success batch.json',
  'Cooking.json',
  'Cute teddy bear with a gift.json',
  'Drone flying.json',
  'Drone with Package.json',
  'Food Courier Accept Order.json',
  'Food Courier.json',
  'Food delivered.json',
  'Food loading.json',
  'Food prep.json',
  'Game asset.json',
  'Gift Box Lottie Animation.json',
  'Gift premium animation.json',
  'Handshake Loop.json',
  'Happy Birthday.json',
  'Happy Dog.json',
  'ItayCheff.json',
  'Loader cat.json',
  'Loading utensils.json',
  'Order Confirmed.json',
  'Programming.json',
  'Recolored job proposal review animation.json',
  'Recruitment.json',
  'Revenue.json',
  'Review.json',
  'Running Cat.json',
  'Ship.json',
  'Social Icons Marketing.json',
  'Social Media Marketing.json',
  'Success.json',
  'Trophy.json',
  'Wedding Destination Couple Merriage.json',
  'cat with salad.json',
  'collaboration.json',
  'community.json',
  'delivery food splash.json',
  'empty.json',
  'fire.json',
  'job cv.json',
  'loading.json',
  'paws animation.json',
  'recording.json',
  'rocket no blackground.json',
  'social media-2.json',
  'social media.json',
  'success confetti.json',
  'thinking.json',
  'voice icon lottie animation.json',
  'welcome.json',
  'wellbeing.json',
];

export default function SideNav() {
  const pathname = usePathname();
  const [currentAnimation, setCurrentAnimation] = useState<any>(null);
  const [animationIndex, setAnimationIndex] = useState(0);

  useEffect(() => {
    // Load the first animation
    const loadAnimation = async () => {
      try {
        const randomIndex = Math.floor(Math.random() * animationFiles.length);
        const animationPath = `/animations/${animationFiles[randomIndex]}`;
        const response = await fetch(animationPath);
        const data = await response.json();
        setCurrentAnimation(data);
        setAnimationIndex(randomIndex);
      } catch (error) {
        console.log('Animation loading failed:', error);
      }
    };

    loadAnimation();

    // Change animation every 8 seconds
    const interval = setInterval(() => {
      loadAnimation();
    }, 8000);

    return () => clearInterval(interval);
  }, []);

  return (
    <>
      {/* Desktop Side Navigation */}
      <aside className="side-nav">
        <div className="side-nav-content">
          {/* Logo/Branding */}
          <div className="nav-logo">
            <div className="logo-icon">
              <Code2 className="w-6 h-6" />
            </div>
            <span className="logo-text">DSA Practice</span>
          </div>

          {/* Navigation Items */}
          <nav className="nav-items">
            {navItems.map((item) => {
              const Icon = item.icon;
              const isActive = pathname === item.href;

              return (
                <Link
                  key={item.name}
                  href={item.href}
                  className={`nav-item ${isActive ? 'nav-item-active' : ''}`}
                >
                  <Icon className="w-5 h-5" />
                  <span>{item.name}</span>
                </Link>
              );
            })}
          </nav>

          {/* Footer with Animation */}
          <div className="nav-footer">
            {/* Random Animation */}
            {currentAnimation && (
              <div className="nav-footer-animation">
                <Lottie
                  animationData={currentAnimation}
                  loop
                  style={{ width: 100, height: 100 }}
                />
              </div>
            )}

            <p className="text-xs font-semibold" style={{ color: '#6b7280' }}>LNCT Training & Placement</p>
            <p className="text-xs font-medium" style={{ color: '#9ca3af' }}>© 2026</p>
          </div>
        </div>
      </aside>

      {/* Mobile Bottom Navigation */}
      <nav className="bottom-nav">
        {navItems.map((item) => {
          const Icon = item.icon;
          const isActive = pathname === item.href;

          return (
            <Link
              key={item.name}
              href={item.href}
              className={`bottom-nav-item ${isActive ? 'bottom-nav-item-active' : ''}`}
            >
              <Icon className="w-5 h-5" />
              <span className="bottom-nav-label">{item.name}</span>
            </Link>
          );
        })}
      </nav>
    </>
  );
}
