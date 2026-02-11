'use client';

import { ExternalLink, Github, Linkedin, FileText, Globe, Code2, Download } from 'lucide-react';
import Image from 'next/image';
import Lottie from 'lottie-react';
import { useEffect, useState } from 'react';

export default function ProfilePage() {
  const [animation, setAnimation] = useState<any>(null);

  useEffect(() => {
    // Load programming animation
    fetch('/animations/Programming.json')
      .then((res) => res.json())
      .then((data) => setAnimation(data))
      .catch(() => console.log('Animation not found'));
  }, []);

  const profiles = [
    {
      name: 'Personal Website',
      icon: Globe,
      url: 'https://www.niteshjatin.me/',
      username: 'niteshjatin.me',
      color: '#667eea',
    },
    {
      name: 'LeetCode',
      icon: Code2,
      url: 'https://leetcode.com/u/jatin8602/',
      username: '@jatin8602',
      color: '#FFA116',
    },
    {
      name: 'GeeksforGeeks',
      icon: Code2,
      url: 'https://www.geeksforgeeks.org/profile/chaurasiyy2ia?tab=overview',
      username: '@chaurasiyy2ia',
      color: '#2F8D46',
    },
    {
      name: 'HackerRank',
      icon: Code2,
      url: 'https://www.hackerrank.com/profile/chaurasiyanites2',
      username: '@chaurasiyanites2',
      color: '#00EA64',
    },
    {
      name: 'GitHub',
      icon: Github,
      url: 'https://github.com/jattu8602',
      username: '@jattu8602',
      color: '#333',
    },
    {
      name: 'LinkedIn',
      icon: Linkedin,
      url: 'https://www.linkedin.com/in/nitesh-chourasiya-a66715292/',
      username: 'Nitesh Chourasiya',
      color: '#0A66C2',
    },
  ];

  return (
    <div className="page-container">
      <div className="profile-container">
        {/* Profile Header with Animation */}
        <div className="profile-header">
          <div className="profile-header-content">
            <div className="profile-avatar-wrapper">
              <Image
                src="/nitesh.jpeg"
                alt="Nitesh Chourasiya"
                width={120}
                height={120}
                className="profile-avatar"
                priority
              />
            </div>
            <h1 className="profile-title">Nitesh Chourasiya</h1>
            <p className="profile-subtitle">Full Stack Developer | DSA Enthusiast</p>
            <p className="profile-bio">
              LNCT Student | Building solutions one algorithm at a time
            </p>
          </div>

          {/* Programming Animation */}
          {animation && (
            <div className="profile-header-animation">
              <Lottie animationData={animation} loop style={{ width: 200, height: 200 }} />
            </div>
          )}
        </div>

        {/* Profile Links */}
        <div className="profile-links-grid">
          {profiles.map((profile) => {
            const Icon = profile.icon;
            return (
              <a
                key={profile.name}
                href={profile.url}
                target="_blank"
                rel="noopener noreferrer"
                className="profile-link-card"
                style={{ '--accent-color': profile.color } as React.CSSProperties}
              >
                <div className="profile-link-icon" style={{ color: profile.color }}>
                  <Icon className="w-6 h-6" />
                </div>
                <div className="profile-link-content">
                  <h3 className="profile-link-title">{profile.name}</h3>
                  <p className="profile-link-username">{profile.username}</p>
                </div>
                <ExternalLink className="w-5 h-5 profile-link-arrow" />
              </a>
            );
          })}
        </div>

        {/* Resume Viewer */}
        <div className="profile-resume-section">
          <div className="profile-resume-header">
            <h2 className="profile-resume-title">
              <FileText className="w-5 h-5" />
              Resume
            </h2>
            <a
              href="/resume_nitesh.pdf"
              download="Nitesh_Chourasiya_Resume.pdf"
              className="profile-resume-download-btn"
              title="Download Resume"
            >
              <Download className="w-4 h-4" />
              <span>Download</span>
            </a>
          </div>

          {/* Embedded PDF Viewer */}
          <div className="profile-resume-viewer">
            <iframe
              src="/resume_nitesh.pdf"
              className="profile-resume-iframe"
              title="Resume Preview"
            />
          </div>
        </div>
      </div>
    </div>
  );
}
