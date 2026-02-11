# 🔥 DSA Practice Tracker

> A modern, beautiful web application to track and showcase your Data Structures & Algorithms journey

[![Next.js](https://img.shields.io/badge/Next.js-16.1.6-black?style=flat&logo=next.js)](https://nextjs.org/)
[![TypeScript](https://img.shields.io/badge/TypeScript-5.0-blue?style=flat&logo=typescript)](https://www.typescriptlang.org/)
[![Tailwind CSS](https://img.shields.io/badge/Tailwind-3.4-38bdf8?style=flat&logo=tailwind-css)](https://tailwindcss.com/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)

[Live Demo](https://www.niteshjatin.me/) • [Report Bug](https://github.com/jattu8602/LNCT_TNP_DSA_DAILYPractice/issues) • [Request Feature](https://github.com/jattu8602/LNCT_TNP_DSA_DAILYPractice/issues)

---

## ✨ Features

### 📊 **Home Page - Auto-Sliding Carousel**
- 🎯 Beautiful auto-sliding code carousel (10-second intervals)
- 📌 Pin/Unpin functionality to pause and study code
- 🎨 LeetCode-style syntax highlighting
- 📝 Displays recent solutions (48-hour filter)
- ⏸️ Prevents sliding when code is pinned

### 🔥 **Streak Tracking**
- 📈 Current streak counter with fire animation
- 🏆 Best streak record
- 📊 Problems solved counter
- 📅 GitHub contributions calendar integration
- 💬 Motivational quotes

### 💻 **All Codes Archive**
- 📚 Complete archive of all DSA solutions
- 🔍 Sortable by date (latest first)
- 🎨 Beautiful card-based layout
- 🔗 Direct LeetCode problem links

### 👤 **Profile Page**
- 🖼️ GitHub avatar integration
- 🌐 Personal website link
- 💼 Professional profile links (LeetCode, GFG, HackerRank, LinkedIn)
- 📄 Resume download
- ✨ Animated card hover effects

### ℹ️ **About Page**
- 📖 Project story and motivation
- 🎓 LNCT TNP connection
- 🎯 Goals and journey
- 🏷️ Topic badges

---

## 🛠️ Tech Stack

- **Framework**: [Next.js 16](https://nextjs.org/) (App Router)
- **Language**: [TypeScript](https://www.typescriptlang.org/)
- **Styling**: [Tailwind CSS](https://tailwindcss.com/)
- **UI Components**: [Shadcn/UI](https://ui.shadcn.com/)
- **Package Manager**: [Bun](https://bun.sh/)
- **Animations**: [Lottie React](https://www.npmjs.com/package/lottie-react)
- **Icons**: [Lucide React](https://lucide.dev/)
- **GitHub Calendar**: [react-github-calendar](https://www.npmjs.com/package/react-github-calendar)

---

## 🚀 Quick Start

### Prerequisites

- **Node.js** 18+ or **Bun** 1.0+
- **Git**

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/jattu8602/LNCT_TNP_DSA_DAILYPractice.git
   cd LNCT_TNP_DSA_DAILYPractice
   ```

2. **Install dependencies**
   ```bash
   bun install
   # or
   npm install
   ```

3. **Run the development server**
   ```bash
   bun run dev
   # or
   npm run dev
   ```

4. **Open your browser**
   Navigate to [http://localhost:3000](http://localhost:3000)

---

## 📁 Project Structure

```
ldtdp/
├── app/                          # Next.js App Router
│   ├── page.tsx                 # Home page (carousel)
│   ├── streak/                  # Streak tracking page
│   ├── codes/                   # All codes archive
│   ├── about/                   # About page
│   ├── profile/                 # Profile page
│   ├── globals.css              # Global styles
│   ├── text-improvements.css   # Text contrast fixes
│   ├── home-carousel.css       # Carousel styles
│   ├── pin-button.css          # Pin button styles
│   ├── streak-colors.css       # Streak page colors
│   ├── about-colors.css        # About page colors
│   └── profile-styles.css      # Profile page styles
│
├── components/                  # React components
│   ├── HomeClient.tsx          # Home carousel client
│   ├── CodeCanvas.tsx          # Code display with syntax highlighting
│   ├── SideNav.tsx             # Desktop/mobile navigation
│   └── ui/                     # Shadcn/UI components
│
├── lib/                        # Utility functions
│   └── getJavaFiles.ts         # File system utilities
│
├── JavaDSA/                    # DSA solutions (Java)
│   ├── ValidParentheses.java
│   ├── TwoSum.java
│   └── ... (all your solutions)
│
├── public/                     # Static assets
│   ├── animations/             # Lottie animations
│   └── resume_nitesh.pdf       # Resume
│
└── next.config.ts              # Next.js configuration
```

---

## 📝 Adding New Solutions

1. **Add your Java file** to the `JavaDSA/` folder
2. **Naming convention**: `ProblemName.java` (PascalCase)
3. **Include LeetCode link** as the first comment:
   ```java
   // https://leetcode.com/problems/problem-name/
   class Solution {
       // Your solution
   }
   ```
4. The website will **automatically detect** and display the new solution!

---

## 🎨 Customization

### Update Personal Information

Edit `app/profile/page.tsx`:
- Profile image URL
- GitHub username
- Social media links
- Resume path

### Modify Streak Data

Streak calculations in `app/page.tsx` and `app/streak/page.tsx` automatically scan the `JavaDSA/` folder.

### Change Theme Colors

Modify color variables in `app/globals.css`:
```css
:root {
  --color-primary: #ff6b35;
  --gradient-1: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  /* ... */
}
```

---

## 🌐 Deployment

### Deploy to Vercel (Recommended)

1. **Push to GitHub**
   ```bash
   git add .
   git commit -m "Initial commit"
   git push origin main
   ```

2. **Import to Vercel**
   - Go to [vercel.com](https://vercel.com)
   - Click "New Project"
   - Import your GitHub repository
   - Deploy! 🚀

### Environment Variables

No environment variables required for basic functionality.

---

## 📸 Screenshots

### Home Page
Auto-sliding carousel with pinnable code display

### Streak Page
Track your consistency with GitHub contributions

### Profile Page
Showcase your coding profiles and download resume

---

## 🤝 Contributing

Contributions are welcome! Feel free to:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Nitesh Chourasiya**

- 🌐 Website: [niteshjatin.me](https://www.niteshjatin.me/)
- 💼 LinkedIn: [Nitesh Chourasiya](https://www.linkedin.com/in/nitesh-chourasiya-a66715292/)
- 🐙 GitHub: [@jattu8602](https://github.com/jattu8602)
- 💻 LeetCode: [@jatin8602](https://leetcode.com/u/jatin8602/)

---

## 🙏 Acknowledgments

- **LNCT Training & Placement Cell** - For guidance and support
- **LeetCode** - For DSA problems and learning resources
- **Next.js Team** - For the amazing framework
- **Shadcn** - For beautiful UI components

---

## 📊 Project Stats

- **Total Solutions**: Automatically counted from `JavaDSA/` folder
- **Current Streak**: Track daily practice consistency
- **Latest Update**: Check the home page carousel

---

<div align="center">

### ⭐ Star this repo if it helped you!

**Made with ❤️ by Nitesh Chourasiya**

*Building one algorithm at a time* 🚀

</div>
