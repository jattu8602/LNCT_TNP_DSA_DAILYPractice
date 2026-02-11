'use client';

import Link from 'next/link';
import { usePathname } from 'next/navigation';
import { Home, Flame, Code2, User, Info } from 'lucide-react';

const navItems = [
  { name: 'Home', href: '/', icon: Home },
  { name: 'Streak', href: '/streak', icon: Flame },
  { name: 'All Codes', href: '/codes', icon: Code2 },
  { name: 'About', href: '/about', icon: Info },
  { name: 'Profile', href: '/profile', icon: User },
];

export default function SideNav() {
  const pathname = usePathname();

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

          {/* Footer */}
          <div className="nav-footer">
            <p className="text-xs text-white/40">LNCT Training & Placement</p>
            <p className="text-xs text-white/30">© 2026</p>
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
