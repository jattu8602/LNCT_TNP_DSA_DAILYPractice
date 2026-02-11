'use client';

import { useState } from 'react';
import { JavaFile } from '@/lib/getJavaFiles';
import { Pin, PinOff } from 'lucide-react';

interface CodeCanvasProps {
  file: JavaFile;
  index: number;
  isPinned?: boolean;
  onPinToggle?: () => void;
}

export default function CodeCanvas({ file, index, isPinned, onPinToggle }: CodeCanvasProps) {
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

  // Simplified syntax highlighting that works correctly
  const highlightJava = (line: string) => {
    // Escape HTML
    let html = line
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');

    // Store original to compare
    const patterns = [
      // Comments - highest priority
      {
        regex: /\/\/.*$/g,
        replacement: (match: string) => `<span class="syntax-comment">${match}</span>`
      },
      {
        regex: /\/\*[\s\S]*?\*\//g,
        replacement: (match: string) => `<span class="syntax-comment">${match}</span>`
      },
      // Strings
      {
        regex: /"(?:[^"\\]|\\.)*"/g,
        replacement: (match: string) => `<span class="syntax-string">${match}</span>`
      },
      {
        regex: /'(?:[^'\\]|\\.)*'/g,
        replacement: (match: string) => `<span class="syntax-string">${match}</span>`
      },
      // Annotations
      {
        regex: /@\w+/g,
        replacement: (match: string) => `<span class="syntax-annotation">${match}</span>`
      },
      // Keywords
      {
        regex: /\b(public|private|protected|static|final|class|interface|extends|implements|void|int|double|float|long|short|byte|char|boolean|String|if|else|while|for|return|new|this|super|try|catch|finally|throw|throws|import|package|Stack|Character)\b/g,
        replacement: (match: string) => `<span class="syntax-keyword">${match}</span>`
      },
      // Function calls (word before opening paren)
      {
        regex: /\b(\w+)(?=\s*\()/g,
        replacement: (match: string) => `<span class="syntax-function">${match}</span>`
      },
      // Numbers
      {
        regex: /\b\d+\.?\d*\b/g,
        replacement: (match: string) => `<span class="syntax-number">${match}</span>`
      }
    ];

    // Apply each pattern
    patterns.forEach(({ regex, replacement }) => {
      html = html.replace(regex, replacement);
    });

    return html;
  };

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

          {/* Pin/Unpin Button (only show if onPinToggle is provided) */}
          {onPinToggle && (
            <button
              onClick={onPinToggle}
              className="pin-btn cursor-pointer"
              aria-label={isPinned ? "Unpin to resume autoplay" : "Pin to pause autoplay"}
              title={isPinned ? "Unpin to resume autoplay" : "Pin to pause autoplay"}
            >
              {isPinned ? (
                <PinOff className="w-5 h-5" />
              ) : (
                <Pin className="w-5 h-5" />
              )}
            </button>
          )}
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

      {/* Code Display with White Background */}
      <div className="code-container code-container-white">
        <pre className="code-pre code-pre-white">
          <code className="code-block">
            {codeLines.map((line, idx) => (
              <div key={idx} className="code-line code-line-white">
                <span className="line-number line-number-white">{idx + 1}</span>
                <span
                  className="line-content"
                  dangerouslySetInnerHTML={{ __html: highlightJava(line) }}
                />
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
