'use client';

import { useState } from 'react';
import { JavaFile } from '@/lib/getJavaFiles';

interface CodeCanvasProps {
  file: JavaFile;
  index: number;
}

export default function CodeCanvas({ file, index }: CodeCanvasProps) {
  const [copied, setCopied] = useState(false);

  const copyToClipboard = async () => {
    await navigator.clipboard.writeText(file.content);
    setCopied(true);
    setTimeout(() => setCopied(false), 2000);
  };

  // Format date
  const formattedDate = new Date(file.dateModified).toLocaleDateString('en-US', {
    month: 'short',
    day: 'numeric',
    year: 'numeric',
  });

  // Add line numbers to code
  const codeLines = file.content.split('\n');

  return (
    <div
      className="code-canvas group"
      style={{ animationDelay: `${index * 100}ms` }}
    >
      {/* Card Header */}
      <div className="canvas-header">
        <div className="flex items-start justify-between gap-4">
          <div className="flex-1 min-w-0">
            <h3 className="filename">{file.filename}</h3>
            <p className="file-date">{formattedDate}</p>
          </div>

          {/* Copy Button */}
          <button
            onClick={copyToClipboard}
            className="copy-btn"
            aria-label="Copy code"
          >
            {copied ? (
              <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 13l4 4L19 7" />
              </svg>
            ) : (
              <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M8 16H6a2 2 0 01-2-2V6a2 2 0 012-2h8a2 2 0 012 2v2m-6 12h8a2 2 0 002-2v-8a2 2 0 00-2-2h-8a2 2 0 00-2 2v8a2 2 0 002 2z" />
              </svg>
            )}
          </button>
        </div>

        {/* LeetCode Question Link */}
        {file.questionLink && (
          <a
            href={file.questionLink}
            target="_blank"
            rel="noopener noreferrer"
            className="question-link"
          >
            <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M10 6H6a2 2 0 00-2 2v10a2 2 0 002 2h10a2 2 0 002-2v-4M14 4h6m0 0v6m0-6L10 14" />
            </svg>
            <span>View Problem on LeetCode</span>
          </a>
        )}
      </div>

      {/* Code Display */}
      <div className="code-container">
        <pre className="code-pre">
          <code className="code-block">
            {codeLines.map((line, idx) => (
              <div key={idx} className="code-line">
                <span className="line-number">{idx + 1}</span>
                <span className="line-content">
                  {/* Detect and render links as clickable */}
                  {line.split(/(https?:\/\/[^\s\)]+)/g).map((part, i) => {
                    if (part.match(/^https?:\/\//)) {
                      return (
                        <a
                          key={i}
                          href={part}
                          target="_blank"
                          rel="noopener noreferrer"
                          className="inline-link"
                          onClick={(e) => e.stopPropagation()}
                        >
                          {part}
                        </a>
                      );
                    }
                    return <span key={i}>{part}</span>;
                  })}
                </span>
              </div>
            ))}
          </code>
        </pre>
      </div>

      {/* Additional Links */}
      {file.links.length > 1 && (
        <div className="canvas-footer">
          <p className="footer-label">Related Links:</p>
          <div className="links-grid">
            {file.links.slice(1).map((link, idx) => (
              <a
                key={idx}
                href={link}
                target="_blank"
                rel="noopener noreferrer"
                className="related-link"
              >
                <svg className="w-3 h-3" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M10 6H6a2 2 0 00-2 2v10a2 2 0 002 2h10a2 2 0 002-2v-4M14 4h6m0 0v6m0-6L10 14" />
                </svg>
                <span className="truncate">{link}</span>
              </a>
            ))}
          </div>
        </div>
      )}
    </div>
  );
}
