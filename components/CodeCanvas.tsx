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

  // Completely rewritten syntax highlighting using position-based approach
  const highlightJava = (line: string) => {
    // Escape HTML first
    const escaped = line
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');

    // Find all matches with their positions
    interface Match {
      start: number;
      end: number;
      text: string;
      className: string;
      priority: number;
    }

    const matches: Match[] = [];

    // Priority: 1 = highest (comments/strings), 5 = lowest (numbers)

    // Comments (priority 1)
    const commentRegex = /\/\/.*$|\/\*[\s\S]*?\*\//g;
    let match;
    while ((match = commentRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-comment',
        priority: 1
      });
    }

    // Strings (priority 2)
    const stringRegex = /"(?:[^"\\]|\\.)*"|'(?:[^'\\]|\\.)*'/g;
    while ((match = stringRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-string',
        priority: 2
      });
    }

    // Annotations (priority 3)
    const annotationRegex = /@\w+/g;
    while ((match = annotationRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-annotation',
        priority: 3
      });
    }

    // Keywords (priority 4)
    const keywordRegex = /\b(public|private|protected|static|final|class|interface|extends|implements|void|int|double|float|long|short|byte|char|boolean|String|if|else|while|for|return|new|this|super|try|catch|finally|throw|throws|import|package|Stack|Character|ListNode)\b/g;
    while ((match = keywordRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-keyword',
        priority: 4
      });
    }

    // Functions (priority 5)
    const functionRegex = /\b(\w+)(?=\s*\()/g;
    while ((match = functionRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-function',
        priority: 5
      });
    }

    // Numbers (priority 6)
    const numberRegex = /\b\d+\.?\d*\b/g;
    while ((match = numberRegex.exec(escaped)) !== null) {
      matches.push({
        start: match.index,
        end: match.index + match[0].length,
        text: match[0],
        className: 'syntax-number',
        priority: 6
      });
    }

    // Sort by priority (lower number = higher priority) then by start position
    matches.sort((a, b) => {
      if (a.priority !== b.priority) return a.priority - b.priority;
      return a.start - b.start;
    });

    // Remove overlapping matches (keep higher priority ones)
    const filteredMatches: Match[] = [];
    for (const match of matches) {
      const overlaps = filteredMatches.some(
        existing => !(match.end <= existing.start || match.start >= existing.end)
      );
      if (!overlaps) {
        filteredMatches.push(match);
      }
    }

    // Sort by position for building the final string
    filteredMatches.sort((a, b) => a.start - b.start);

    // Build the highlighted HTML
    let result = '';
    let lastIndex = 0;

    for (const match of filteredMatches) {
      // Add text before this match
      result += escaped.substring(lastIndex, match.start);
      // Add the highlighted match
      result += `<span class="${match.className}">${match.text}</span>`;
      lastIndex = match.end;
    }

    // Add remaining text
    result += escaped.substring(lastIndex);

    return result;
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
