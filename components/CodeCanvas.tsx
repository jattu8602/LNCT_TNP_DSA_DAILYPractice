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

  // Add syntax highlighting for Java code - FIXED VERSION
  const highlightJava = (line: string) => {
    // Escape HTML first to prevent injection
    let escaped = line
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;');

    // Use placeholder approach to avoid regex conflicts
    const replacements: Array<{id: string, html: string}> = [];
    let idCounter = 0;

    // Pattern 1: Comments (highest priority - must be first)
    escaped = escaped.replace(/(\/\/.*$|\/\*[\s\S]*?\*\/)/g, (match) => {
      const id = `__COMMENT_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-comment">${match}</span>` });
      return id;
    });

    // Pattern 2: Strings
    escaped = escaped.replace(/(["'])((?:\\.|(?!\1).)*?)\1/g, (match) => {
      const id = `__STRING_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-string">${match}</span>` });
      return id;
    });

    // Pattern 3: Annotations
    escaped = escaped.replace(/(@[a-zA-Z]+)/g, (match) => {
      const id = `__ANNOTATION_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-annotation">${match}</span>` });
      return id;
    });

    // Pattern 4: Keywords
    escaped = escaped.replace(/\b(public|private|protected|static|final|class|interface|extends|implements|void|int|double|float|long|short|byte|char|boolean|String|if|else|while|for|return|new|this|super|try|catch|finally|throw|throws|import|package|Stack)\b/g, (match) => {
      const id = `__KEYWORD_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-keyword">${match}</span>` });
      return id;
    });

    // Pattern 5: Function calls
    escaped = escaped.replace(/\b([a-zA-Z_][a-zA-Z0-9_]*)\s*(?=\()/g, (match) => {
      const id = `__FUNCTION_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-function">${match}</span>` });
      return id;
    });

    // Pattern 6: Numbers
    escaped = escaped.replace(/\b(\d+\.?\d*)\b/g, (match) => {
      const id = `__NUMBER_${idCounter++}__`;
      replacements.push({ id, html: `<span class="syntax-number">${match}</span>` });
      return id;
    });

    // Replace all placeholders with actual HTML
    let result = escaped;
    replacements.forEach(({id, html}) => {
      result = result.replace(id, html);
    });

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
