import { getJavaFiles } from '@/lib/getJavaFiles';
import CodeCanvas from '@/components/CodeCanvas';

export const dynamic = 'force-dynamic';

export default async function Home() {
  const javaFiles = await getJavaFiles();

  return (
    <div className="page-container">
      {/* Hero Section */}
      <div className="hero-section">
        <div className="hero-content">
          <div className="badge">
            <span className="badge-dot"></span>
            <span>Training & Placement</span>
          </div>

          <h1 className="hero-title">
            Daily <span className="gradient-text">DSA Practice</span>
          </h1>

          <p className="hero-subtitle">
            Java & Data Structures problems solved daily for placement success
          </p>

          <div className="stats-grid">
            <div className="stat-card">
              <div className="stat-value">{javaFiles.length}</div>
              <div className="stat-label">Problems Solved</div>
            </div>
            <div className="stat-card">
              <div className="stat-value">
                {javaFiles.filter(f => f.questionLink?.includes('leetcode')).length}
              </div>
              <div className="stat-label">LeetCode Questions</div>
            </div>
            <div className="stat-card">
              <div className="stat-value">
                {javaFiles.length > 0
                  ? Math.ceil((new Date().getTime() - new Date(javaFiles[javaFiles.length - 1].dateModified).getTime()) / (1000 * 60 * 60 * 24))
                  : 0}
              </div>
              <div className="stat-label">Day Streak</div>
            </div>
          </div>
        </div>
      </div>

      {/* Code Canvas Grid */}
      <div className="content-section">
        {javaFiles.length === 0 ? (
          <div className="empty-state">
            <div className="empty-icon">
              <svg className="w-16 h-16" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={1.5} d="M10 20l4-16m4 4l4 4-4 4M6 16l-4-4 4-4" />
              </svg>
            </div>
            <h2 className="empty-title">No Java Files Yet</h2>
            <p className="empty-description">
              Add your daily Java DSA practice files to the <code className="inline-code">JavaDSA</code> folder to see them here.
            </p>
            <div className="empty-hint">
              <p className="text-sm">💡 Tip: Add a LeetCode link at the top of your file as a comment</p>
            </div>
          </div>
        ) : (
          <>
            <div className="section-header">
              <h2 className="section-title">Latest Solutions</h2>
              <p className="section-subtitle">Sorted by most recent first</p>
            </div>

            <div className="canvas-grid">
              {javaFiles.map((file, index) => (
                <CodeCanvas key={file.relativePath} file={file} index={index} />
              ))}
            </div>
          </>
        )}
      </div>
    </div>
  );
}
